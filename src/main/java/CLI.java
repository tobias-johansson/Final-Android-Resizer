import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class CLI {

    public void run(String[] args) {

        showInfo("Processing..");

        int j = 0;

        File resFile = new File(args[j++]);

        String inputDensity = args[j++];

        Vector<File> fileVector = new Vector<File>();
        while (j < args.length) {
            fileVector.add(new File(args[j++]));
        }
        File[] files = new File[fileVector.size()];
        fileVector.toArray(files);

        Vector<String> export = getExportFolders();

        for (int i = 0; i < files.length; i++) {
            for (String exportString : export) {
                try {
                    showInfo(files[i].toString());
                    ImageProcessor.processImage(files[i], resFile, inputDensity, exportString);
                } catch (FileAlreadyExistsException e) {
                    showWarning("The file " + files[i].getName() + " already exists! This image will not be processed.");
                    break;
                } catch (IOException e) {
                    showError("An IO Error occurred while processing " + files[i].getName());
                    e.printStackTrace();
                    break;
                } catch (NullPointerException e) {
                    showError("The file " + files[i].getName() + " is not an image and will be omitted");
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


    private Vector<String> getExportFolders() {
        Vector<String> ret = new Vector<String>();
        ret.add("ldpi");
        ret.add("mdpi");
        ret.add("hdpi");
        ret.add("xhdpi");
//        ret.add("xxhdpi");

        return ret;
    }
}
