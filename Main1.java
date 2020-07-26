public abstract class Observer {
    protected Programmer programmer;
    public abstract void update();
}
public class CEO extends Observer {

    public CEO(Programmer programmer) {
        this.programmer = programmer;
        this.programmer.attach(this);
    }
    
    @Override
    public void update() {
        if(this.programmer.getState().equalsIgnoreCase("Successful")) {
            System.out.println("CEO is happy with Manager and Lead Programmer.");
        } else {
            System.out.println("CEO is unhappy with Manager and Lead Programmer.");
        }
    }
}

public class Manager extends Observer {
    
    public Manager(Programmer programmer) {
        this.programmer = programmer;
        this.programmer.attach(this);
    }
    
    @Override
    public void update() {
        if(this.programmer.getState().equalsIgnoreCase("Successful")) {
            System.out.println("Manager is happy with Lead Programmer and this Programmer.");
        } else {
            System.out.println("Manager is unhappy with Lead Programmer and this Programmer.");
        }
    }
}

public class LeadProgrammer extends Observer {

    public LeadProgrammer(Programmer programmer) {
        this.programmer = programmer;
        this.programmer.attach(this);
    }
    
     @Override
    public void update() {
        if(this.programmer.getState().equalsIgnoreCase("Successful")) {
            System.out.println("Lead Programmer is proud of his Programmer.");
        } else {
            System.out.println("Lead Programmer is not proud of his Programmer.");
        }
    }
}
public class Main1 {
    public static void main(String[] args) {
        Programmer programmer = new Programmer();
        
        new CEO(programmer);
        new Manager(programmer);
        new LeadProgrammer(programmer);
        
        System.out.println("Programmer successfully did his job!");
        programmer.setState("Successful");
        System.out.println("Programmer failed his new assignment.");
        programmer.setState("Failed");
    }
}