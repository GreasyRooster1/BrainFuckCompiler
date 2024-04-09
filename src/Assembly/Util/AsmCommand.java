package Assembly.Util;

public abstract class AsmCommand {
    public String identifier;

    public AsmCommand() {

    }

    public String parse(String[] sectors){
        return null;
    }
    public String parseWithFlags(String[] sectors, String[] flags){
        return this.parse(sectors);
    }
}
