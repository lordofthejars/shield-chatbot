package org.acme.ai;

public enum HarmPolicy {

    DANGEROUS("""
    harming oneself and/or others (e.g., accessing or building firearms
         and explosive devices, promotion of terrorism, instructions for
         suicide)
    """),
    HATE("""
        targeting identity and/or protected attributes (e.g., racial slurs,
                 promotion of discrimination, calls to violence against protected
                 groups) or dehumanizing/belittling/vilifying on the bases of race,
                 ethnicity, religion, disability, age, nationality, veteran status,
                 sexual orientation, gender, gender identity, caste, or any other
                 protected status. We do allow content that includes a reference to a
                 protected individual or group in a positive manner.
        """),
    SEXUAL("""
        contains references to sexual acts or other lewd content (e.g.,
                 sexually graphic descriptions, content aimed at causing arousal).
                 Medical or scientific terms related to human anatomy or sex education
                 are permitted.
        """),
    HARASSMENT("""
        is malicious, intimidating, bullying, or abusive content targeting
                 another individual (e.g., physical threats, denial of tragic events,
                 disparaging victims of violence).
        """);


    private String description;

    HarmPolicy(String desc) {
        this.description = desc;
    }

    public String getDescription() {
        return this.description;
    }

}
