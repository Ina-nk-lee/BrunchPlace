package main.ui;

import javax.swing.*;

public class CurrentOrdersPane extends JSplitPane {
    private ButtonHandler buttonHandler;
    private final int DIVIDER_LOC = 480;
    private JScrollPane recordPane;
    private JPanel rightPanel;

    public CurrentOrdersPane(ButtonHandler buttonHandler) {
        this.buttonHandler = buttonHandler;
    }

    private void setPanes() {
        setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        setDividerLocation(DIVIDER_LOC);
        setLeftComponent(recordPane);
        setRightComponent(rightPanel);
        setEnabled(false);
    }

    private void setRecordPane() {
        recordPane = new JScrollPane();
        JTextArea record = new JTextArea("");
        record.setEditable(false);
        recordPane.setViewportView(record);
        recordPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        recordPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    }
}
