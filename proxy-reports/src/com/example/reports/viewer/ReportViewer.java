package com.example.reports.viewer;

import com.example.reports.models.User;
import com.example.reports.report.Report;

public class ReportViewer {

    public void open(Report report, User user) {
        report.display(user);
    }
}