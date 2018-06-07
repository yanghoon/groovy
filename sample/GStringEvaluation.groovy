
def context = [image: 'bluegreen:0.0.3']

def closure = { println "docker build -t $image ." }
closure.delegate = context
closure()

println Eval.me('image', 'bluegreen:0.0.3', '"docker build -t $image ."')

println Eval.me('e', context, '"docker build -t $e.image ."')

/* 
 * evaluation of GString with Custom Context
 * - http://mrhaki.blogspot.com/2009/11/groovy-goodness-simple-evaluation-of.html
 * - http://grepcode.com/file/repo1.maven.org/maven2/org.codehaus.groovy/groovy-all/2.4.4/groovy/util/Eval.java#98
 */
Binding b = new Binding(context)
GroovyShell sh = new GroovyShell(b)
println sh.evaluate('"docker build -t $image ."')
