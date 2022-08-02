public class Student {
    String name,stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    double avarage;
    boolean isPass;


    Student(String name, int classes, String stuNo, Course mat,Course fizik,Course kimya) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        calcAvarage();
        this.isPass = false;
    }

    public void addBulkExamNote(int mat, int fizik, int kimya) {

        if (mat >= 0 && mat <= 100) {
            this.mat.note = mat;
        }

        if (fizik >= 0 && fizik <= 100) {
            this.fizik.note = fizik;
        }

        if (kimya >= 0 && kimya <= 100) {
            this.kimya.note = kimya;
        }

    }

    public void addBulkVerbalNote(int verbalMat, int verbalFizik, int verbalKimya){
        if (verbalMat >= 0 && verbalMat <= 100) {
            this.mat.verbalNote = verbalMat;
        }

        if (verbalFizik >= 0 && verbalFizik <= 100) {
            this.fizik.verbalNote = verbalFizik;
        }

        if (verbalKimya >= 0 && verbalKimya <= 100) {
            this.kimya.verbalNote = verbalKimya;
        }



    }

    public void isPass() {
        if (this.mat.note == 0 || this.fizik.note == 0 || this.kimya.note == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAvarage() {
        double fizikAvg = (this.fizik.note * 0.75) + (this.fizik.verbalNote * 0.25);
        double matAvg = (this.mat.note * 0.90) + (this.fizik.verbalNote * 0.10);
        double kimyaAvg = (this.kimya.note * 0.85) + (this.kimya.verbalNote * 0.15);
        this.avarage = (fizikAvg + matAvg + kimyaAvg) / 3;
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    public void printNote(){
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.mat.note);
        System.out.println("Fizik Notu : " + this.fizik.note);
        System.out.println("Kimya Notu : " + this.kimya.note);
    }

}