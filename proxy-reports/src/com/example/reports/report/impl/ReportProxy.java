package com.example.reports.report.impl;

import com.example.reports.models.User;
import com.example.reports.report.Report;
import com.example.reports.utils.AccessControl;

/**
 * TODO (student):
 * Implement Proxy responsibilities here:
 * - access check
 * - lazy loading
 * - caching of RealReport within the same proxy
 */
public class ReportProxy implements Report {

    private final String reportId;
    private final String title;
    private final String classification;
    private final AccessControl accessControl = new AccessControl();
    private RealReport report = null;

    public ReportProxy(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;
    }

    public void display(User user) {
        if (accessControl.canAccess(user, classification)) {
            if (report == null) {
                report = new RealReport(reportId, title, classification);
            }
            report.display(user);
        } else {
            System.out.println("Access denied");
        }

    }
}