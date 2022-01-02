#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")
/**
 * <p><b>Annotation {@link ${NAME}}</b></p>
 *
 * @author ${USER}
 * @version #parse("Version.txt")
 * @since #parse("Version.txt")
 */
public @interface ${NAME} {
}
