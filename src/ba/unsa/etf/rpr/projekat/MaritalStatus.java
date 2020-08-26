package ba.unsa.etf.rpr.projekat;

public enum MaritalStatus {
    SINGLE {
        @Override
        public String toString() {
            return "single";
        }
    }, MARRIED {
        @Override
        public String toString() {
            return "married";
        }
    }, DIVORCED {
        @Override
        public String toString() {
            return "divorced";
        }
    }, WIDOWED {
        @Override
        public String toString() {
            return "widowed";
        }
    }
}
