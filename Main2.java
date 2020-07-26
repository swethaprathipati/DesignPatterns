public interface Iterator {
    public boolean hasNext();
    public Object next();
}

public interface Sector {
    public Iterator getIterator();
}

public class EmployeeRepository implements Sector {
    public String[] employees = {"David", "Scott", "Rhett", "Andrew", "Jessica"};

    @Override
    public Iterator getIterator() {
        return new EmployeeIterator();
    }
    
    private class EmployeeIterator implements Iterator {
        int index;
        
        @Override
        public boolean hasNext() {
            if(index < employees.length) {
                return true;
            } 
            return false;
        }

        @Override
        public Object next() {
            if(this.hasNext()) {
                return employees[index++];
            }
            return null;
        }
    }
}

public class Main2 {
    public static void main(String[] args) {

        EmployeeRepository employeeRepository = new EmployeeRepository();

        for(Iterator iterator = employeeRepository.getIterator(); 
                iterator.hasNext();) {
            String employee = (String)iterator.next();
            System.out.println("Employee: " + employee);
        }
    }
}
