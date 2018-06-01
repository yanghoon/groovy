def config = [containers:[[name:'maven', image:'maven:3.3.9-jdk-8-alpine', ttyEnabled:true, command:'cat'], [name:'docker', image:'docker', ttyEnabled:true, command:'cat']], volumes:[[hostPathVolume:[hostPath:'/var/run/docker.sock', mountPath:'/var/run/docker.sock']], [hostPathVolume:[hostPath:'/var/run/docker.sock', mountPath:'/var/run/docker.sock']]]]

def hostPathVolume(Map map){
    return "!!hostPathVolume($map)"
}

// Groovy Spread Operation
println config.volumes*.collect { "${it.key}"(it.value) }
println config.volumes.collect {
    it.collect { "${it.key}"(it.value) }
}

def volumes = config.volumes*.collect { "${it.key}"(it.value) }
volumes = volumes.flatten()
println volumes
