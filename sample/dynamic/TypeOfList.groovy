/* Hello World in Groovy */
println (["a", 'b', 'c', 1] as String[])
println (["a", 'b', 'c', 1][3].class)
def arr = (["a", 'b', 'c', 1] as String[])
println arr[3].class

println (["a", 'b', 'c'].inject(true) {r,e -> r && e in String})

private def consistOf(def obj, def type){
	obj in List && obj.inject(true){r,e -> r && e in type}	
}

println consistOf(["a", "b", "c", 1], String)
