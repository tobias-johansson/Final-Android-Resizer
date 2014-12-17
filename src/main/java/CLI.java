import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.spi.StringArrayOptionHandler;

public class CLI {

    @Option(name = "-in-res", usage = "input resolution", required = true)
    private String inRes = null;

    @Option(name = "-out-res", usage = "list of output resolutions", required = true, handler = StringArrayOptionHandler.class)
    private List<String> outRess = null;

    @Option(name = "-out-dir", usage = "output dir", required = true)
    private File outDir = null;

    @Argument
    private List<File> files = new ArrayList<File>();

    public void run(String[] args) {

        CmdLineParser parser = new CmdLineParser(this);

        try {
            parser.parseArgument(args);
            if( files.isEmpty() ) throw new CmdLineException(parser,"No argument is given");
        } catch( CmdLineException e ) {
            System.err.println(e.getMessage());
            parser.printUsage(System.err);
            return;
        }

        showInfo("Processing..");

        for (File file : files) {
            for (String outRes : outRess) {
                try {
                    String finalPath = ImageProcessor.processImage(file, outDir, inRes, outRes);
                    showInfo("Wrote " + finalPath);
                } catch (FileAlreadyExistsException e) {
                    showWarning("Skipping (" + e.getMessage() + ")");
                } catch (IOException e) {
                    showError("An IO Error occurred while processing " + file.getName());
                    e.printStackTrace();
                    break;
                } catch (NullPointerException e) {
                    showError("The file " + file.getName() + " is not an image and will be omitted");
                    e.printStackTrace();
                    break;
                }
            }
        }
        showInfo("Done!");
    }


    public void showInfo(String msg) {
        System.out.println(msg);
    }

    public void showWarning(String msg) {
        System.err.println("WARNING: " + msg);
    }

    public void showError(String msg) {
        System.err.println("ERROR: " + msg);
    }


    private ArrayList<String> getExportFolders() {
        ArrayList<String> ret = new ArrayList<String>();
        ret.add("ldpi");
        ret.add("mdpi");
        ret.add("hdpi");
        ret.add("xhdpi");
//        ret.add("xxhdpi");

        return ret;
    }
}
