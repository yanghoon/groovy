def config = [containers:[[name:'maven', image:'maven:3.3.9-jdk-8-alpine', ttyEnabled:true, command:'cat'], [name:'docker', image:'docker', ttyEnabled:true, command:'cat']], volumes:[[hostPathVolume:[hostPath:'/var/run/docker.sock', mountPath:'/var/run/docker.sock']]]]


def args = [[name:'maven', command:'bash']]
def comp = {it.name == arg.name}

def merge(config, args, comp){
  args.each { arg ->
    comp.delegate = [arg:arg]
	  comp.resolveStrategy = Closure.DELEGATE_FIRST
			
    def found = config.containers.find comp
    (found ?: config.containers) << arg
  }
}

merge(config, args, comp)

println config
