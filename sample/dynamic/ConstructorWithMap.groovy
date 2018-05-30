class Sub {
    def name
    def enable
}

class Main {
    def name
    def version
    Sub[] sub
}

def main = [name:'APP #1', version:10]
println main as Main
println new Main(main).dump()

def sub1 = [name:'SUB #1', enable:true]
def sub2 = [name:'SUB #2', enable:false]
main.sub = [new Sub(sub1), new Sub(sub2)]
println new Main(main).dump()
