def env = [foo:'xxx', bar:[bee:'$foo', vee:'${boo[1]}'], boo:[0,'aa','3']]
Binding b = new Binding(env)
GroovyShell sh = new GroovyShell(b)

env.each {
    def key = it.key
    def val = it.value in Map || it.value in List ? it.value.inspect() : it.value
    env[key] = sh.evaluate("\"$val\"")
    //(${key.class.simpleName}) (${val.class.simpleName})
    print "($key: $val-> ${env[key]}) :: "
    print "(${key.getClass().simpleName}: ${val.getClass().simpleName}-> ${it.value.getClass().simpleName})"
    println ""
    //println " -> ${env[it.key]}(${env[it.key].class.simpleName})"
}

println(env)
println(env.toMapString())
println(env.inspect())
