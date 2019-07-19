package ajplarson.flooringmastery.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

//From Corbin March's Lottery program
public abstract class FileDao<T> {

    private String path;
    private int columnCount = 12;
    private boolean hasHeaders = true;
    private String header = "OrderNumber,CustomerName,State,TaxRate,ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot,MaterialCost,LaborCost,Tax,Total";

    public FileDao() {

    }

    public FileDao(String path, int columnCount, boolean hasHeaders) {
        this.path = path;
        this.columnCount = columnCount;
        this.hasHeaders = hasHeaders;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    public boolean isHasHeaders() {
        return hasHeaders;
    }

    public void setHasHeaders(boolean hasHeaders) {
        this.hasHeaders = hasHeaders;
    }

    public void setDate(LocalDate date) {
        String pattern = "MMddyyyy";
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern(pattern);
        path = String.format("files/Orders_%s.txt", formatDate.format(date));
    }

    public List<T> read(Function<String[], T> mapper) throws StorageException {

        ArrayList<T> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            if (hasHeaders) { // throw out header...
                reader.readLine();
            }

            String line;
            while ((line = reader.readLine()) != null) {

                String[] tokens = line.split(",");

                if (tokens.length == columnCount) {
                    T obj = mapper.apply(tokens);
                    if (obj != null) {
                        result.add(obj);
                    }
                }
            }
        } catch (IOException ex) {
            throw new StorageException(ex.getMessage(), ex);
        }
        return result;
    }

    public void write(Collection<T> items, Function<T, String> mapper) throws StorageException {
        try (PrintWriter writer = new PrintWriter(path)) {
            for (T obj : items) {
                if (obj != null) {
                    writer.println(mapper.apply(obj));
                }
            }
        } catch (IOException ex) {
            throw new StorageException(ex.getMessage(), ex);
        }
    }
    
    public void editWrite(Collection<T> items, Function<T, String> mapper) throws StorageException {
        try (PrintWriter writer = new PrintWriter(path)) {
            writer.println(header);
            for (T obj : items) {
                if (obj != null) {
                    writer.println(mapper.apply(obj));
                }
            }
        } catch (IOException ex) {
            throw new StorageException(ex.getMessage(), ex);
        }
    }

    public void append(T item, Function<T, String> mapper) throws StorageException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
            writer.println(mapper.apply(item));
        } catch (IOException ex) {
            throw new StorageException(ex.getMessage(), ex);
        }
    }

    public void appendHeader() throws StorageException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, true))) {
            writer.println(header);
        } catch (IOException ex) {
            throw new StorageException(ex.getMessage(), ex);
        }
    }
}
