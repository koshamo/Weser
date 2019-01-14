/*
 * Copyright [2018] [Dr. Jochen Raßler]
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     or see LICENSE file in the project root
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package weser.gui.controls;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Orientation;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class WideScreenReader extends Region {

	private final int VGAP = 20;
	/*
	 * settings fields with default values
	 */
	private int numOfColumns = 2;
	private boolean showTableOfContent = false;
	private boolean showStickPane = false;
	
	private List<TextFlow> textViewers;
	private ScrollBar scrollBar;
	
	// just for development / testing
	String text = "this is a very long text!\n"
			+ "I need this one, to test the content of the TextFlow " 
			+ "or derived component.\n\n"
			+ "Can you give me some ideas how I can expand this senseless "
			+ "speech over and over and talk senseless things, "
			+ "just to fill up the component?\n"
			+ "Any glue? Any Hint?\n"
			+ "Maybe, that's enough for now.";
	public WideScreenReader() {
		buildComponent();
	}

	private void buildComponent() {
		textViewers = new ArrayList<>();
		HBox hbox = new HBox(VGAP);
		for (int i = 0; i < numOfColumns; i++) 
			textViewers.add(new TextFlow(new Text(text)));
		
		scrollBar = new ScrollBar();
		scrollBar.setOrientation(Orientation.VERTICAL);
		scrollBar.setMax(0.0);
		
		hbox.getChildren().addAll(textViewers);
		hbox.getChildren().add(scrollBar);
		this.getChildren().add(hbox);
	}
	
	@Override
	protected double computePrefWidth(double height) {
		return super.computePrefWidth(height);
	}	

	@Override
	protected double computePrefHeight(double width) {
		return super.computePrefHeight(width);
	}
	
	@Override
	protected void layoutChildren() {
		double barWidth = 15.0;
		double textFlowWidth = (getWidth() - barWidth - numOfColumns * VGAP) 
								/ numOfColumns;
		for (TextFlow tf : textViewers)
			tf.setPrefSize(textFlowWidth, getHeight());
		super.layoutChildren();
	}
}
