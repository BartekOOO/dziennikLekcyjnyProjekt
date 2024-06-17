public class Krotka {
        private int id;
        private String nazwa;

        public Krotka(int id, String nazwa) {
            this.id = id;
            this.nazwa = nazwa;
        }


        public int getId() {
            return id;
        }

        public String getNazwa() {
            return nazwa;
        }

        @Override
        public String toString() {
            return nazwa;
        }

}
