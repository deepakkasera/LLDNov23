package org.example.designpatterns.prototype;

public class Client {
    private static void fillRegistry(StudentRegistry registry) {
        Student mar22MorningStudent = new Student();
        mar22MorningStudent.setBatch("Mar22 Morning");
        mar22MorningStudent.setAvgBatchPsp(70.0);
        registry.register("mar22MorningStudent", mar22MorningStudent);

        IntelligentStudent mar22MorningIntelligentStudent =
                new IntelligentStudent();
        mar22MorningIntelligentStudent.setIq(180);
        mar22MorningIntelligentStudent.setBatch("Mar22 Morning");
        mar22MorningIntelligentStudent.setAvgBatchPsp(70.0);
        registry.register("mar22MorningIntelligentStudent", mar22MorningIntelligentStudent);
    }
    public static void main(String[] args) {
        //Fill the registry with template objects.
        StudentRegistry registry = new StudentRegistry();
        fillRegistry(registry);

        Student parag = registry.get("mar22MorningStudent").copy();
        parag.setName("Parag");
        parag.setAge(25);
        parag.setPsp(80.0);

        Student koteshwara = registry.get("mar22MorningIntelligentStudent").copy();

        System.out.println("DEBUG");
    }
}
