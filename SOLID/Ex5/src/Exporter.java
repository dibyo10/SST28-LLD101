public abstract class Exporter {
    public final ExportResult export(ExportRequest req) {
        if (req == null) {
            return new ExportResult("text/plain", new byte[0]);
        }
        String title = req.title == null ? "" : req.title;
        String body = req.body == null ? "" : req.body;
        return doExport(title, body);
    }

    protected abstract ExportResult doExport(String title, String body);
}
