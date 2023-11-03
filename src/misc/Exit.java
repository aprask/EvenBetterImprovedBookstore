package misc;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Exit
{
    public Exit()
    {

    }
    public void thankYou() throws IOException {
        String URL = "src/misc/sales_report.html";
        File file = new File(URL);
        Desktop.getDesktop().browse(file.toURI());
    }
}
