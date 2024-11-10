package com.lms.gui;

import javax.swing.*;
import java.awt.*;

public class DashboardPanel extends JPanel {
    private MainFrame mainFrame;
    private JTabbedPane tabbedPane;
    
    public DashboardPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());
        
        // Create top panel with user info and logout
        JPanel topPanel = createTopPanel();
        add(topPanel, BorderLayout.NORTH);
        
        // Create tabbed pane for different sections
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("My Courses", createCoursesPanel());
        tabbedPane.addTab("Available Courses", createAvailableCoursesPanel());
        tabbedPane.addTab("Progress", createProgressPanel());
        tabbedPane.addTab("Forums", createForumsPanel());
        
        add(tabbedPane, BorderLayout.CENTER);
    }
    
    private JPanel createTopPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JLabel userLabel = new JLabel("Welcome, User!");
        panel.add(userLabel, BorderLayout.WEST);
        
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> mainFrame.showLogin());
        panel.add(logoutButton, BorderLayout.EAST);
        
        return panel;
    }
    
    private JPanel createCoursesPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        // Create a list model for courses
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Java Programming 101");
        listModel.addElement("Web Development Basics");
        listModel.addElement("Database Design");
        
        JList<String> courseList = new JList<>(listModel);
        courseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane scrollPane = new JScrollPane(courseList);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createAvailableCoursesPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        String[] columns = {"Course Name", "Instructor", "Duration", "Price"};
        Object[][] data = {
            {"Advanced Java", "John Doe", "8 weeks", "$99"},
            {"Python Basics", "Jane Smith", "6 weeks", "$79"},
            {"Data Structures", "Bob Wilson", "10 weeks", "$129"}
        };
        
        JTable coursesTable = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(coursesTable);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createProgressPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        // Create progress bars for different courses
        JPanel progressPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        progressPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        addCourseProgress(progressPanel, "Java Programming 101", 75);
        addCourseProgress(progressPanel, "Web Development Basics", 45);
        addCourseProgress(progressPanel, "Database Design", 90);
        
        panel.add(new JScrollPane(progressPanel), BorderLayout.CENTER);
        
        return panel;
    }
    
    private void addCourseProgress(JPanel panel, String courseName, int progress) {
        JPanel coursePanel = new JPanel(new BorderLayout(10, 5));
        coursePanel.add(new JLabel(courseName), BorderLayout.NORTH);
        
        JProgressBar progressBar = new JProgressBar(0, 100);
        progressBar.setValue(progress);
        progressBar.setStringPainted(true);
        coursePanel.add(progressBar, BorderLayout.CENTER);
        
        panel.add(coursePanel);
    }
    
    private JPanel createForumsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        // Create a split pane for forums list and discussion
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        
        // Forums list
        DefaultListModel<String> forumsModel = new DefaultListModel<>();
        forumsModel.addElement("General Discussion");
        forumsModel.addElement("Technical Support");
        forumsModel.addElement("Course Questions");
        
        JList<String> forumsList = new JList<>(forumsModel);
        splitPane.setLeftComponent(new JScrollPane(forumsList));
        
        // Discussion area
        JTextArea discussionArea = new JTextArea();
        discussionArea.setEditable(false);
        splitPane.setRightComponent(new JScrollPane(discussionArea));
        
        panel.add(splitPane, BorderLayout.CENTER);
        
        return panel;
    }
}