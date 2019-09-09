/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.warmupjuly8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author ajplarson
 */
public class WordReaderDao extends FileDao<String> {

    private final String path = "resources/wordlist.txt";
    private final int columnCount = 1;
    private final boolean hasHeaders = false;

    @Override
    public List<String> findAll() {
        try {
            return read(this::mapToCustomer).stream()
                    .collect(Collectors.toList());
        } catch (StorageException ex) {
            return new ArrayList<>();
        }
    }

    @Override
    public void add(Customer customer) throws StorageException {
        append(customer, this::mapToString);
    }

}
