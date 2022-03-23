package platform.codingnomads.co.corespring.examples.application_context.xml;

import lombok.*;

/**
 * A new POJO that represents a database that might be used by a software developer.
 *
 * A bean and config for this class is defined in the accompanying xml file at:
 * resources/xml-config/codingnomad_configuration.xml
 *
 * In the CodingNomad class, a final field for this class is added for it to be
 * injected.
 *
 * @author sm@creativefusion.net
 */
@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class Database {
    private String name;
    private String version;
}
