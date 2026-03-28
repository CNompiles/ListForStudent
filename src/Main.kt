import java.util.*

data class Student(
    val id: Int,
    val name: String,
    var grade: Double
) {
    init {
        require(grade in 0.0..10.0) { "Ο βαθμός πρέπει να είναι μεταξύ 0.0 και 10.0" }
    }

    override fun toString(): String {
        return "ID: %03d | Όνομα: %-15s | Βαθμός: %.1f".format(id, name, grade)
    }
}

class GradeTracker {
    private val students = mutableListOf<Student>()

    fun addStudent(student: Student) = students.add(student)

    fun removeStudent(id: Int): Boolean {
        val removed = students.removeIf { it.id == id }
        if (!removed) println("Σφάλμα: Δεν βρέθηκε φοιτητής με ID $id.")
        return removed
    }

    fun getAllStudents(): List<Student> = students.toList()

    fun calculateAverage(): Double {
        if (students.isEmpty()) {
            println("Σφάλμα: Η λίστα είναι κενή.")
            return 0.0
        }
        return students.map { it.grade }.average()
    }

    fun getHighestGrade(): Student? = students.maxByOrNull { it.grade }

    fun getFailingStudents(): List<Student> = students.filter { it.grade < 5.0 }

    fun getExcellentStudents(): List<Student> = students.filter { it.grade >= 8.5 }
}

fun main() {
    val tracker = GradeTracker()

    tracker.addStudent(Student(1, "Νίκος Παππάς", 4.5))
    tracker.addStudent(Student(2, "Μαρία Παπαδά", 9.2))
    tracker.addStudent(Student(3, "Γιώργος Λάμπρου", 3.0))
    tracker.addStudent(Student(4, "Ελένη Κώστα", 8.7))
    tracker.addStudent(Student(5, "Ανδρέας Ζήνων", 6.5))
    tracker.addStudent(Student(6, "Σοφία Μάνου", 5.2))

    println("---  Λίστα όλων των φοιτητών ---")
    tracker.getAllStudents().forEach { println(it) }

    println("\n---  Μέσος Όρος Βαθμολογίας ---")
    println("%.2f".format(tracker.calculateAverage()))

    println("\n---  Αποτυχόντες (< 5.0) ---")
    tracker.getFailingStudents().forEach { println(it) }

    println("\n---  Άριστοι (>= 8.5) ---")
    tracker.getExcellentStudents().forEach { println(it) }

    println("\n---  Αφαίρεση φοιτητή με ID 3 ---")
    tracker.removeStudent(3)

    println("Νέα λίστα φοιτητών:")
    tracker.getAllStudents().forEach { println(it) }

    println("\n---  Φοιτητής με τον υψηλότερο βαθμό ---")
    println(tracker.getHighestGrade() ?: "Δεν υπάρχουν φοιτητές.")
}