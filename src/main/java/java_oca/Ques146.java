package java_oca;

// Output:  Compilation fails at n2
//          {because the implementing method is trying to lower the access level from public to default.}

interface  Exportable {
    void export();
}

class Tool implements Exportable {
   public void export() {                      // line n1
       System.out.println("Tool::export");
   }
}

class ReportTool extends Tool {
     // void export() {                        // line n2
     //   System.out.println("RTool::export");
    // }
}


public class Ques146 {
    public static void main(String[] args) {
        Tool aTool = new ReportTool();
        Tool bTool = new Tool();
        callExport(aTool);
        callExport(bTool);
    }

    public static void callExport(Exportable ex) {
        ex.export();
    }
}
