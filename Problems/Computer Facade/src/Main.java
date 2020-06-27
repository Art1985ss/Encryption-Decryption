class ComputerFacadeTestDrive {
    public static void main(String[] args) {
        ComputerFacade computerFacade = new ComputerFacade(new Processor(), new Monitor(), new Keyboard());

        computerFacade.turnOnComputer();
        computerFacade.turnOffComputer();
    }
}

class ComputerFacade {
    private Processor processor;
    private Monitor monitor;
    private Keyboard keyboard;

    public ComputerFacade(Processor processor, Monitor monitor, Keyboard keyboard) {
        this.processor = processor;
        this.monitor = monitor;
        this.keyboard = keyboard;
    }

    public void turnOnComputer() {
        processor.on();
        monitor.on();
        keyboard.on();
    }

    public void turnOffComputer() {
        keyboard.off();
        monitor.off();
        processor.off();
    }
}

class Processor {
    private String name = "Processor";

    public void on() {
        System.out.println(name + " on");
    }

    public void off() {
        System.out.println(name + " off");
    }
}

class Monitor {
    private String name = "Monitor";

    public void on() {
        System.out.println(name + " on");
    }

    public void off() {
        System.out.println(name + " off");
    }
}

class Keyboard {
    private String name = "Keyboard";

    public void on() {
        System.out.println(name + " on");
        this.turnOnBacklight();
    }

    public void off() {
        System.out.println(name + " off");
        this.turnOffBacklight();
    }

    private void turnOnBacklight() {
        System.out.println("Backlight is turned on");
    }

    private void turnOffBacklight() {
        System.out.println("Backlight is turned off");
    }
}