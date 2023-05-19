package com.planetsystems.events.feature_events.domain.util

import com.planetsystems.events.R
import com.planetsystems.events.feature_events.domain.model.Attendee
import com.planetsystems.events.feature_events.domain.model.Event

val dummyEvents = listOf(
    Event(
        id = 1,
        name = "World Youth Summit",
        image = "",
        imageRes = R.drawable.wb_youth_summit,
        date = "TODAY",
        time = "8:00 AM",
        location = "Online",
        attendance = "8/10",
        organizerName = "World Bank",
        organizerImage = "",
        description = "Established in 2013, the Youth Summit is an annual event held by the World Bank Group (WBG) to engage with youth globally on the most pressing topics facing their generation. The primary goals of the Summit are to (1) empower youth to explore innovative ideas for tackling development challenges, (2) provide youth with the tools to build and engage in impactful projects, and (3) promote dialogue between youth, the WBG, and other key stakeholders globally."
    ),
    Event(
        id = 2,
        name = "World Bank CyberTalks",
        image = "",
        imageRes = R.drawable.wb_cyber_talks,
        date = "April 20, 2023",
        time = "8:00 AM",
        location = "Online",
        attendance = "8/10",
        organizerName = "World Bank",
        organizerImage = "",
        description = "As countries become more digitalized, they are also increasingly vulnerable to cyber risks and challenges that threaten the security and resilience of their networked infrastructures and systems and can erode public trust in the digital environment. Threats to cybersecurity, data protection, and privacy are global, and that’s why addressing them requires a holistic, coordinated, collaborative approach. "
    ),
    Event(
        id = 3,
        name = "Environmental and Social Framework (ESF)",
        image = "",
        imageRes = R.drawable.wb_esf,
        date = "TODAY",
        time = "7:00 AM",
        location = "Online",
        attendance = "8/10",
        organizerName = "World Bank",
        organizerImage = "",
        description = "The Environmental and Social Framework (ESF) Dialogue Series provides an opportunity to explore the most pertinent ESF-related issues and challenges, while strengthening collaboration and partnerships with diverse stakeholders from across the world. The series provides an opportunity for technical experts to share information and obtain feedback from stakeholders on the opportunities and challenges in their work. It also enables peers to share insights on solutions that could be adapted across countries."
    ),
    Event(
        id = 4,
        name = "GPS Seminar Series",
        image = "",
        imageRes = R.drawable.wb_gps_seminar_series,
        date = "Feb 28, 2023",
        time = "8:00 AM",
        location = "Online",
        attendance = "8/10",
        organizerName = "World Bank",
        organizerImage = "",
        description = "The Global Program on Sustainability (GPS) Seminar Series shares the latest knowledge on how policy makers and the financial sector can integrate environmental sustainability considerations into decision making. Knowledge sharing and learning are central to GPS' goals, and these virtual sessions present an opportunity to highlight real-life case-studies, ongoing work and lessons learned from countries that are beginning to look beyond GDP and traditional financial metrics to account for environmental risks and opportunities.\n" +
                "\n"
    ),
    Event(
        id = 5,
        name = "Governance Global Practice Book Talks",
        image = "",
        imageRes = R.drawable.wb_governance_global,
        date = "Aug 20, 2023",
        time = "9:00 AM",
        location = "Online",
        attendance = "8/10",
        organizerName = "World Bank",
        organizerImage = "",
        description = "The Governance Global Practice Book Talks presents recent books by leading global experts. These books were written for a broad audience and cover public policy areas that are relevant for Governance and beyond.\n" +
                "\n"
    ),
    Event(
        id = 6,
        name = "Macroeconomics, Trade, and Finance Seminars",
        image = "",
        imageRes = R.drawable.wb_macroeconomics_trade,
        date = "Feb 01, 2023",
        time = "10:00 AM",
        location = "Online",
        attendance = "8/10",
        organizerName = "World Bank",
        organizerImage = "",
        description = "The Macroeconomics, Trade, and Finance Seminar Series is a weekly series hosted by the World Bank's research department. The series invites leading researchers from the fields of macroeconomics, growth, trade, international integration, and finance to present the results of their recent research in a seminar format.\n" +
                "\n"
    ),
    Event(
        id = 7,
        name = "Microeconomics Seminar Series",
        image = "",
        imageRes = R.drawable.wb_microeconomics,
        date = "Feb 15, 2023",
        time = "8:00 AM",
        location = "Online",
        attendance = "8/10",
        organizerName = "World Bank",
        organizerImage = "",
        description = "The Microeconomics Seminar Series is a weekly series hosted by the World Bank's research department. The series invites leading researchers in applied microeconomics from the fields of poverty, human development, agriculture, political economy, behavioral economics, private sector development, and a range of other fields to present the results of their most recent research in a seminar format.\n" +
                "\n"
    ),
    Event(
        id = 8,
        name = "Business Outreach Workshops for Ukraine",
        image = "",
        imageRes = R.drawable.wb_business_ukraine,
        date = "May 11, 2023",
        time = "11:00 AM",
        location = "Online",
        attendance = "18/100",
        organizerName = "World Bank",
        organizerImage = "",
        description = "Russia’s invasion of Ukraine has caused enormous damage to infrastructure, services, and government systems in Ukraine. The international community, including Multilateral Development Banks working with the Government of Ukraine, is providing emergency assistance to restore services and repair damaged infrastructure. The international community is also planning for the reconstruction of Ukraine, which will require massive financial assistance. Procurement of goods, works, and services will be critical to the reconstruction program."
    ),
    Event(
        id = 9,
        name = "Global Payments Week 2023",
        image = "",
        imageRes = R.drawable.wb_global_payments,
        date = "May 15, 2023",
        time = "8:00 AM",
        location = "Online",
        attendance = "2/30",
        organizerName = "World Bank",
        organizerImage = "",
        description = "The “Global Payments Week” (GPW) is a biennial event that bring together payment systems experts from central banks, co-organized by the World Bank and the Committee on Payments and Market\n" +
                "\n" +
                "Infrastructures (CPMI) of the Bank for International Settlements (BIS), in partnership with international and regional bodies such as the International Monetary Fund (IMF), the Arab Monetary Fund, and the Center for Latin American Monetary Studies (CEMLA)."
    ),
    Event(
        id = 10,
        name = "The Disruptive Economics of Artificial Intelligence",
        image = "",
        imageRes = R.drawable.wb_ai,
        date = "May 17, 2023",
        time = "12:00 AM",
        location = "Online",
        attendance = "0/10",
        organizerName = "World Bank",
        organizerImage = "",
        description = "Avi Goldfarb (Chair of Artificial Intelligence & Healthcare at University of Toronto) talks about the disruptive economics of artificial intelligence. This talk is organized by the World Bank, Georgetown University and Korea Institute for Industrial Economics and Trade. \n" +
                "\n"
    )
)

val dummyAttendees = listOf(
    Attendee(
        firstName = "Peter",
        lastName = "John",
        title = "Mr.",
        organisation = "World Vision",
        nin = "CMDKDKEUE9393E3",
        phone = "0700908765",
        gender = "M"
    ),
    Attendee(
        firstName = "Sarah",
        lastName = "Jane",
        title = "Ms.",
        organisation = "Google",
        nin = "CNJDJD303JEJ3ME",
        phone = "0786543776",
        gender = "M"
    ),
    Attendee(
        firstName = "Sam",
        lastName = "Poda",
        title = "Dr.",
        organisation = "World Bank",
        nin = "CNDJDJIE9E3JEJE",
        phone = "0700376538",
        gender = "M"
    ),
    Attendee(
        firstName = "Fredrick",
        lastName = "Royal",
        title = "Mr.",
        organisation = "Planet Systems",
        nin = "CNDJDI93939393D",
        phone = "0766543973",
        gender = "M"
    ),
    Attendee(
        firstName = "Kylian",
        lastName = "Mbappe",
        title = "Mr.",
        organisation = "PSG",
        nin = "CMDKIEIE9393EEK",
        phone = "0799876539",
        gender = "M"
    ),
    Attendee(
        firstName = "Pascal",
        lastName = "Musisi",
        title = "Mr.",
        organisation = "Makerere University",
        nin = "CMDKDIIE9393JFR",
        phone = "0788764509",
        gender = "M"
    ),
    Attendee(
        firstName = "Elizabeth",
        lastName = "Mutinda",
        title = "Ms.",
        organisation = "Andela",
        nin = "CFDUEEKEOEJEHEE",
        phone = "0798765443",
        gender = "M"
    ),
    Attendee(
        firstName = "Olivier",
        lastName = "Giroud",
        title = "Mr.",
        organisation = "PSG",
        nin = "CMDKDIE93IK3JE",
        phone = "0799826358",
        gender = "M"
    )
)