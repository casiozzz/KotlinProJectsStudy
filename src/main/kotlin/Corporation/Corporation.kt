package Corporation

fun main() {
    val workers = WorkersRepository.workers
    for (worker in workers){
        worker.work()
    }
}