package Assembly.Util;

import Assembly.AsmCommand;
import Assembly.Commands.Advanced.RawCommand;
import Assembly.Commands.ControlFlow.*;
import Assembly.Commands.IO.DbgCommand;
import Assembly.Commands.IO.InpCommand;
import Assembly.Commands.IO.PntCommand;
import Assembly.Commands.Math.*;
import Assembly.Commands.Memory.CpyCommand;
import Assembly.Commands.Memory.MovCommand;
import Assembly.Commands.Memory.SetCommand;
import Assembly.Commands.Memory.SwpCommand;

import static Utils.Utils.append;

public class AsmCommandRegistry {
    public static AsmCommand[] registry = {};
    
    public static void registerCommands(){
        //TODO: DYS DYF
        register(new SetCommand());
        register(new PntCommand());
        register(new InpCommand());
        register(new IfoCommand());
        register(new IfcCommand());
        register(new JptCommand());
        register(new JmpCommand());
        register(new AddCommand());
        register(new SubCommand());
        register(new AdmCommand());
        register(new SbmCommand());
        register(new MovCommand());
        register(new DbgCommand());
        register(new NopCommand());
        register(new CpyCommand());
        register(new SwpCommand());
        register(new MulCommand());
        register(new RawCommand());
    }
    
    private static void register(AsmCommand cmd){
        registry = (AsmCommand[]) append(registry,cmd);
    }
}
