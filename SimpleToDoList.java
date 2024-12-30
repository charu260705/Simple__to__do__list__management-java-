import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SimpleToDoList {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("To-Do List Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Create components
        JTextField taskInput = new JTextField();
        JButton addButton = new JButton("Add Task");
        JButton clearButton = new JButton("Clear All");
        DefaultListModel<String> taskModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(taskModel);

        // Panel for input and buttons
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(taskInput, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        // Panel for the list and clear button
        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.add(new JScrollPane(taskList), BorderLayout.CENTER);
        listPanel.add(clearButton, BorderLayout.SOUTH);

        // Add panels to the frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(listPanel, BorderLayout.CENTER);

        // Add task button action
        addButton.addActionListener(e -> {
            String task = taskInput.getText().trim();
            if (!task.isEmpty()) {
                taskModel.addElement(task);
                taskInput.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Task cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Clear all tasks button action
        clearButton.addActionListener(e -> {
            if (taskModel.size() > 0) {
                int confirm = JOptionPane.showConfirmDialog(frame, "Are you sure you want to clear all tasks?", 
                        "Confirm Clear", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    taskModel.clear();
                }
            } else {
                JOptionPane.showMessageDialog(frame, "No tasks to clear!", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Show the frame
        frame.setVisible(true);
    }
}
