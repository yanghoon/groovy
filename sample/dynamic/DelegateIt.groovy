def eachMap(List<Map> list, def body){
  list.each {
    it.each {
      // 'it' represent a single argument, so can not delegate 'it'.
      body.delegate = ['it2':it]
      body.resolveStrategy = Closure.DELEGATE_FIRST
      
      body(it)
    }
  }
}

def conf = [[maven:['mvn clean install', '-Dmaven.test.skip=true']], [docker:'docker version']]
def body = {
  println "$it.key = $it.value"
  println "$it2.key = $it2.value"
  println (it == it2)
}

eachMap(conf, body)
