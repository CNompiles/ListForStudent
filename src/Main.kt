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