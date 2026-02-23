import java.nio.charset.StandardCharsets;

public class CsvExporter extends Exporter {
    @Override
    protected ExportResult doExport(String title, String body) {
        String sanitized = body.replace("\n", " ").replace(",", " ");
        String csv = "title,body\n" + title + "," + sanitized + "\n";
        return new ExportResult("text/csv", csv.getBytes(StandardCharsets.UTF_8));
    }
}
