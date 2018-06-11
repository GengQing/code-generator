package ${package};

import lombok.*;
import java.util.List;

/**
<#if modelDescription??>
 * <P> ${modelDescription!} </P>
</#if>
 * Created by ${author} on ${date}
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ${modelName} {
<#list properties as p>
    private ${p.type} ${p.name};
</#list>



}
