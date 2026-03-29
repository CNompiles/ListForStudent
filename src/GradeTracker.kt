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