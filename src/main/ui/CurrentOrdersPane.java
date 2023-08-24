package main.ui;

import javax.swing.*;
import java.awt.*;

public class CurrentOrdersPane extends JSplitPane {
    private ButtonHandler buttonHandler;
    private final int DIVIDER_LOC = 480;
    private JScrollPane recordPane;
    private JPanel rightPane;

    public CurrentOrdersPane(ButtonHandler buttonHandler) {
        this.buttonHandler = buttonHandler;
        setPanes();
    }

    private void setPanes() {
        setRecordPane();
        setRightPane();

        setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        setDividerLocation(DIVIDER_LOC);
        setLeftComponent(recordPane);
        setRightComponent(rightPane);
        setEnabled(false);
    }

    private void setRecordPane() {
        recordPane = new JScrollPane();
        JTextArea record = new JTextArea("");
        record.setEditable(false);
        recordPane.setViewportView(record);
        recordPane.setPreferredSize(new Dimension(500, 350));
        recordPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        recordPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    }

    private void setRightPane() {
        rightPane = new JPanel();
        rightPane.setLayout(new BoxLayout(rightPane, BoxLayout.Y_AXIS));

        JPanel emptyPane = new JPanel();
        emptyPane.setPreferredSize(new Dimension(500, 350));

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> buttonHandler.openMainMenu());

        rightPane.add(emptyPane);
        rightPane.add(backButton);
    }
}
