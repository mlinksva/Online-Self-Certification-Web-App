/**
 * Copyright (c) 2016 Source Auditor Inc.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
*/
package org.openchain.certification.model;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

/**
 * Top level class for the survey itself.  The survey consists of sections.  
 * Sections contains questions.  Questions have correct answers and can be validated
 * against those questions.
 * @author Gary O'Neall
 *
 */
public class Survey {
	private List<Section> sections;

	/**
	 * @return the sections
	 */
	public List<Section> getSections() {
		return sections;
	}

	/**
	 * @param sections the sections to set
	 */
	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	/**
	 * @return a set of all question numbers in the survey
	 */
	public Set<String> getQuestionNumbers() {
		HashSet<String> retval = new HashSet<String>();
		for (Section section:sections) {
			List<Question> questions = section.getQuestions();
			for (Question question:questions) {
				retval.add(question.getNumber());
			}
		}
		return retval;
	}

	public Question getQuestion(String questionNumber) {
		// TODO this is not the fastest, but it is accurate
		for (Section section:sections) {
			List<Question> questions = section.getQuestions();
			for (Question question:questions) {
				if (Objects.equals(question.getNumber(), questionNumber)) {
					return question;
				}
			}
		}
		return null;
	}
	
}
