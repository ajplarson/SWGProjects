
var margin = 20,
diameter = 960;

var color = d3.scale.linear().domain([-1, 5]).range(["hsl(152,80%,80%)", "hsl(228,30%,40%)"]).interpolate(d3.interpolateHcl);

var pack = d3.layout.pack().padding(2).size([diameter - margin, diameter - margin]).value(function(d) { return d.size; })

///////////////////////
/* buttons */
var buttonData = ["flare.json", "flare1.json", "flare2.json"];
var buttonDiv = d3.select("body").append("svg").attr("width", diameter).attr("height", 50);
var buttons = buttonDiv.selectAll(".updateButton").data(buttonData).enter().append('g').attr("class", "updateButton").on("click", function(d, i) {callJson(d);   });
buttons.append("rect").attr("x", function(d, i) { return (i * 100) + 300; }).attr("width", 98).attr("height", 25).attr("ry", 5).style("stroke", "#787878").style("fill", "steelblue");
buttons.append("text").attr("x", function(d, i) { return (i * 100) + (100 / 2) + 290; }) .attr("y", 12).attr("dy", "0.35em").style("text-anchor", "middle").style("font-size", "15px").text(function(d) { return d; });
///////////////////////   


var svg = d3.select("body").append("svg").attr("width", diameter).attr("height", diameter).append("g").attr("transform", "translate(" + diameter / 2 + "," + diameter / 2 + ")");

var callJson = function (json) {
d3.json(json, function(error, root) {
if (error) return console.error(error);

svg.selectAll("circle").remove();
svg.selectAll("text").remove();

var focus = root,
    nodes = pack.nodes(root),
    view;

var circle = svg.selectAll("circle").data(nodes).enter().append("circle").attr("class", function(d) { return d.parent ? d.children ? "node" : "node node--leaf" : "node node--root"; }).style("fill", function(d) { return d.children ? color(d.depth) : null; }).on("click", function(d) { if (focus !== d) zoom(d), d3.event.stopPropagation(); });

var text = svg.selectAll("text").data(nodes).enter().append("text").attr("class", "label").style("fill-opacity", function(d) { return d.parent === root ? 1 : 0; }).style("display", function(d) { return d.parent === root ? null : "none"; }).text(function(d) { return d.name; });

var node = svg.selectAll("circle,text");

d3.select("body").style("background", color(-1)).on("click", function() { zoom(root); });

zoomTo([root.x, root.y, root.r * 2 + margin]);

function zoom(d) {
  var focus0 = focus; focus = d;

  var transition = d3.transition().duration(d3.event.altKey ? 7500 : 750).tween("zoom", function(d) {
        var i = d3.interpolateZoom(view, [focus.x, focus.y, focus.r * 2 + margin]);
        return function(t) { zoomTo(i(t)); };
      });

  transition.selectAll("text").filter(function(d) { return d.parent === focus || this.style.display === "inline"; }).style("fill-opacity", function(d) { return d.parent === focus ? 1 : 0; }).each("start", function(d) { if (d.parent === focus) this.style.display = "inline"; }).each("end", function(d) { if (d.parent !== focus) this.style.display = "none"; });
}

function zoomTo(v) {
  var k = diameter / v[2]; view = v;
  node.attr("transform", function(d) { return "translate(" + (d.x - v[0]) * k + "," + (d.y - v[1]) * k + ")"; });
  circle.attr("r", function(d) { return d.r * k; });
}
});
};

callJson("flare.json");

d3.select(self.frameElement).style("height", diameter + "px");
