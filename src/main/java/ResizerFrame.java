/*
 *
 
 Copyright (c) 2014, Sebastian Breit
All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.

3. Neither the name of the <ORGANIZATION> nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 
 
 * 
 * */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class ResizerFrame extends JFrame {

	private JPanel contentPane;
	private JPanel panel_1;
	private JLabel lblResourcesDirectory;
	private JButton btnBrowse;
	private JLabel lblNoDirectorySelected;
	private JLabel lblDragYourImages;
	private JPanel panel_2;
	private JLabel lblDragYourImages_1;
	private JPanel panel_3;
	private JLabel lblNewLabel;
	private JPanel panel_4;
	private JLabel lblDragDrop;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResizerFrame frame = new ResizerFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	File resFile = null;
	private JLabel lblInputDensity;
	private JComboBox inputDensity;
	private JCheckBox ch_xxxhdpi;
	private JCheckBox ch_tvdpi;
	private JCheckBox ch_ldpi;
	private JCheckBox ch_mdpi;
	private JCheckBox ch_hdpi;
	private JCheckBox ch_xhdpi;
	private JCheckBox ch_xxhdpi;

	public ResizerFrame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder("Export"));
		contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 56, 0 };
		gbl_panel.rowHeights = new int[] { 23, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 1.0 };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		ch_ldpi = new JCheckBox("ldpi");
		ch_ldpi.setSelected(true);
		GridBagConstraints gbc_ch_ldpi = new GridBagConstraints();
		gbc_ch_ldpi.insets = new Insets(0, 0, 5, 5);
		gbc_ch_ldpi.anchor = GridBagConstraints.NORTHWEST;
		gbc_ch_ldpi.gridx = 0;
		gbc_ch_ldpi.gridy = 0;
		panel.add(ch_ldpi, gbc_ch_ldpi);

		ch_mdpi = new JCheckBox("mdpi");
		ch_mdpi.setSelected(true);
		ch_mdpi.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_ch_mdpi = new GridBagConstraints();
		gbc_ch_mdpi.anchor = GridBagConstraints.WEST;
		gbc_ch_mdpi.insets = new Insets(0, 0, 5, 5);
		gbc_ch_mdpi.gridx = 0;
		gbc_ch_mdpi.gridy = 1;
		panel.add(ch_mdpi, gbc_ch_mdpi);

		ch_tvdpi = new JCheckBox("tvdpi");
		GridBagConstraints gbc_ch_tvdpi = new GridBagConstraints();
		gbc_ch_tvdpi.anchor = GridBagConstraints.WEST;
		gbc_ch_tvdpi.insets = new Insets(0, 0, 5, 5);
		gbc_ch_tvdpi.gridx = 0;
		gbc_ch_tvdpi.gridy = 2;
		panel.add(ch_tvdpi, gbc_ch_tvdpi);

		ch_hdpi = new JCheckBox("hdpi");
		ch_hdpi.setSelected(true);
		GridBagConstraints gbc_ch_hdpi = new GridBagConstraints();
		gbc_ch_hdpi.anchor = GridBagConstraints.WEST;
		gbc_ch_hdpi.insets = new Insets(0, 0, 5, 5);
		gbc_ch_hdpi.gridx = 0;
		gbc_ch_hdpi.gridy = 3;
		panel.add(ch_hdpi, gbc_ch_hdpi);

		ch_xhdpi = new JCheckBox("xhdpi");
		ch_xhdpi.setSelected(true);
		GridBagConstraints gbc_ch_xhdpi = new GridBagConstraints();
		gbc_ch_xhdpi.anchor = GridBagConstraints.WEST;
		gbc_ch_xhdpi.insets = new Insets(0, 0, 5, 5);
		gbc_ch_xhdpi.gridx = 0;
		gbc_ch_xhdpi.gridy = 4;
		panel.add(ch_xhdpi, gbc_ch_xhdpi);

		ch_xxhdpi = new JCheckBox("xxhdpi");
		ch_xxhdpi.setSelected(true);
		GridBagConstraints gbc_ch_xxhdpi = new GridBagConstraints();
		gbc_ch_xxhdpi.anchor = GridBagConstraints.WEST;
		gbc_ch_xxhdpi.insets = new Insets(0, 0, 5, 5);
		gbc_ch_xxhdpi.gridx = 0;
		gbc_ch_xxhdpi.gridy = 5;
		panel.add(ch_xxhdpi, gbc_ch_xxhdpi);

		ch_xxxhdpi = new JCheckBox("xxxhdpi");
		GridBagConstraints gbc_ch_xxxhdpi = new GridBagConstraints();
		gbc_ch_xxxhdpi.insets = new Insets(0, 0, 5, 5);
		gbc_ch_xxxhdpi.gridx = 0;
		gbc_ch_xxxhdpi.gridy = 6;
		panel.add(ch_xxxhdpi, gbc_ch_xxxhdpi);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder("Options"));
		contentPane.add(panel_1, BorderLayout.NORTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0 };
		panel_1.setLayout(gbl_panel_1);

		lblResourcesDirectory = new JLabel("Resources directory:");
		GridBagConstraints gbc_lblResourcesDirectory = new GridBagConstraints();
		gbc_lblResourcesDirectory.anchor = GridBagConstraints.WEST;
		gbc_lblResourcesDirectory.insets = new Insets(0, 0, 5, 5);
		gbc_lblResourcesDirectory.gridx = 0;
		gbc_lblResourcesDirectory.gridy = 0;
		panel_1.add(lblResourcesDirectory, gbc_lblResourcesDirectory);

		btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser j = new JFileChooser();
				j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				Integer returnVal = j.showOpenDialog(btnBrowse);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					resFile = j.getSelectedFile();
					lblNoDirectorySelected.setText(resFile.getAbsolutePath());
					pack();
				}
			}
		});
		GridBagConstraints gbc_btnBrowse = new GridBagConstraints();
		gbc_btnBrowse.insets = new Insets(0, 0, 5, 5);
		gbc_btnBrowse.gridx = 1;
		gbc_btnBrowse.gridy = 0;
		panel_1.add(btnBrowse, gbc_btnBrowse);

		lblNoDirectorySelected = new JLabel("No directory selected yet");
		GridBagConstraints gbc_lblNoDirectorySelected = new GridBagConstraints();
		gbc_lblNoDirectorySelected.insets = new Insets(0, 0, 5, 0);
		gbc_lblNoDirectorySelected.gridx = 2;
		gbc_lblNoDirectorySelected.gridy = 0;
		panel_1.add(lblNoDirectorySelected, gbc_lblNoDirectorySelected);

		lblInputDensity = new JLabel("Input density");
		GridBagConstraints gbc_lblInputDensity = new GridBagConstraints();
		gbc_lblInputDensity.anchor = GridBagConstraints.WEST;
		gbc_lblInputDensity.insets = new Insets(0, 0, 0, 5);
		gbc_lblInputDensity.gridx = 0;
		gbc_lblInputDensity.gridy = 1;
		panel_1.add(lblInputDensity, gbc_lblInputDensity);

		Vector comboBoxItems = new Vector();
		comboBoxItems.add("ldpi");
		comboBoxItems.add("mdpi");
		comboBoxItems.add("hdpi");
		comboBoxItems.add("xhdpi");
		comboBoxItems.add("xxhdpi");
		final DefaultComboBoxModel model = new DefaultComboBoxModel(
				comboBoxItems);
		inputDensity = new JComboBox(model);
		inputDensity.setSelectedIndex(4);
		GridBagConstraints gbc_inputDensity = new GridBagConstraints();
		gbc_inputDensity.insets = new Insets(0, 0, 0, 5);
		gbc_inputDensity.fill = GridBagConstraints.HORIZONTAL;
		gbc_inputDensity.gridx = 1;
		gbc_inputDensity.gridy = 1;
		panel_1.add(inputDensity, gbc_inputDensity);

		panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		lblDragDrop = new JLabel("Drag & drop your image(s) here");
		panel_4.add(lblDragDrop, gbc);

		new FileDrop(System.out, panel_4, /* dragBorder, */
		new FileDrop.Listener() {
			public void filesDropped(final java.io.File[] files) {

				if (resFile == null) {
					showWarning("Please select a destination folder first!");
					return;
				}

				lblDragDrop.setText("Processing..");
				Thread t = new Thread(new Runnable() {

					@Override
					public void run() {
						Vector<String> export = getExportFolders();

						for (int i = 0; i < files.length; i++) {
							for (String exportString : export) {
								try {
									ImageProcessor.processImage(files[i],
											resFile, (String) inputDensity
													.getSelectedItem(),
											exportString);
								} catch (FileAlreadyExistsException e) {
									showWarning("The file "
											+ files[i].getName()
											+ " already exists! This image will not be processed.");
									break;
								} catch (IOException e) {
									showError("An IO Error occurred while processing "
											+ files[i].getName());
									e.printStackTrace();
									break;
								} catch (NullPointerException e) {
									showError("The file "
											+ files[i].getName()
											+ " is not an image and will be omitted");
									e.printStackTrace();
									break;
								}

								lblDragDrop.setText(lblDragDrop.getText() + ".");
							}
						}
						lblDragDrop.setText("Done! Gimme some more...");
					}
				});
				t.start();

			}
		});

	}

	private Vector<String> getExportFolders() {
		Vector<String> ret = new Vector<String>();

		if (ch_ldpi.isSelected())
			ret.add("ldpi");

		if (ch_mdpi.isSelected())
			ret.add("mdpi");

		if (ch_tvdpi.isSelected())
			ret.add("tvdpi");

		if (ch_hdpi.isSelected())
			ret.add("hdpi");

		if (ch_xhdpi.isSelected())
			ret.add("xhdpi");

		if (ch_xxhdpi.isSelected())
			ret.add("xxhdpi");

		if (ch_xxxhdpi.isSelected())
			ret.add("xxxhdpi");

		return ret;
	}

	private void showError(String text) {
		JOptionPane.showMessageDialog(this, text, "Error",
				JOptionPane.ERROR_MESSAGE);
	}

	private void showWarning(String text) {
		JOptionPane.showMessageDialog(this, text, "Warning",
				JOptionPane.WARNING_MESSAGE);
	}

}
