/*
 * This project is licensed under the MIT license. Module model-view-viewmodel is using ZK framework licensed under LGPL (see lgpl-3.0.txt).
 *
 * The MIT License
 * Copyright © 2014-2022 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.iluwatar.ruleengine;
/**
 * This rule states:
 * The candidate has a decent level of education.
 * Doctoral: 20 points
 * Master: 15 points
 * Bachelor: 10 points
 * Diploma: 5 points
 * None of above: 0 points
 */
class TertiaryQualificationRule implements ImmigrationRule {
  /**
   * Check if this TertiaryQualification rule can be executed or not.
   *
   * @param candidate : the current candidate
   * @return boolean : true if the candidate has met the  TertiaryQualification rule
   * @author Dehao Liu
   */
  @Override
  public boolean shouldRun(Candidate candidate) {
    return candidate.getTertiaryQualification() != null;
  }

  /**
   * Execute this  TertiaryQualification  rule.
   *
   * @param candidate : the current candidate
   * @author Dehao Liu
   */
  @Override
  public int runRule(Candidate candidate) {
    String tertiaryQualification = candidate.getTertiaryQualification();

    switch (tertiaryQualification) {
      case "Doctoral degree":
        return 20;
      case "Master degree":
        return 15;
      case "Bachelor degree":
        return 10;
      case "Diploma degree":
        return 5;
      default:
        return 0;
    }
  }
}