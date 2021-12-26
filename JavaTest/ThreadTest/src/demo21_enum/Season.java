package demo21_enum;

public enum Season {
    spring("春"){
    @Override
    public void show() {
        System.out.println(this.name());
    }
},
    summer("夏"){
        @Override
        public void show() {
            System.out.println(this.name());
        }
    },
    autumn("秋"){
        @Override
        public void show() {
            System.out.println(this.name());
        }
    },
    winter("冬"){
        @Override
        public void show() {
            System.out.println(this.name());
        }
    };
    private String name;
    Season() {
    }

    Season(String name) {
        this.name = name;
    }

    public abstract void show();
}
