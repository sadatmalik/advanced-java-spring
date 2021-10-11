package platform.codingnomads.co.ioc.lab.initial;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
@RequiredArgsConstructor
public class CodingNomad {
    private final JDK jdk; // constructor injected - JDK, IDE, Framework
    private final IDE ide;
    private final Framework framework;

    @Autowired
    private Template template; // field injected

    private Data data; // setter injected

    @Autowired
    public void setData(Data data) {
        this.data = data;
    }

    public String createAwesomeSoftware() {
        return MessageFormat
                .format("This Coding Nomad is creating awesome software using, " +
                                "IDE: ({0}:{1}), JDK: ({2}:{3}), Framework: ({4}:{5}), " +
                                "Template: ({6}:{7}), Data: ({8}, {9})",
                        ide.getName(),
                        ide.getVersion(),
                        jdk.getName(),
                        jdk.getVersion(),
                        framework.getName(),
                        framework.getVersion(),
                        template.getName(),
                        template.getVersion(),
                        data.getName(),
                        data.getVersion()
                );
    }
}