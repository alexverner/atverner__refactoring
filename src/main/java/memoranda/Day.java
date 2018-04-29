package main.java.memoranda;

import main.java.memoranda.date.CalendarDate;
import nu.xom.Attribute;
import nu.xom.Element;
/**
 * TASK 2-1 SMELL WITHIN A CLASS
 * Large Class: From Events Manager
 *
 */
class Day {
	Element dEl = null;
	Element mElement;

	public Day(Element el) {
		dEl = el;
	}

	public int getValue() {
		return new Integer(dEl.getAttribute("day").getValue()).intValue();
	}

	/*
	 * public Note getNote() { return new NoteImpl(dEl);
	 */

	public Element getElement() {
		return dEl;
	}
	
	public Day createDay(int d) {
        Element el = new Element("day");
        el.addAttribute(new Attribute("day", new Integer(d).toString()));
        el.addAttribute(
            new Attribute(
                "date",
                new CalendarDate(
                    d,
                    getValue(),
                    new Integer(
                        ((Element) mElement.getParent())
                            .getAttribute("year")
                            .getValue())
                        .intValue())
                    .toString()));

        mElement.appendChild(el);
        return new Day(el);
    }
}