# ph-jdmc

Status: **work in progress**

Java Domain Model Creator (jdmc).
The source structure is defined in JSON, and the domain model, test classes and XML serialization for usage on the "ph-" stack is created.
See the `ph-jdmc-example` subproject which is purely created by the unit tests of `ph-jdmc-core`.

The `ph-jdmc-maven-plugin` subproject is a Maven plugin to use JDMC in your projects.

## File format

The `.jdm` files are JSON files having a certain predefined layout.
There are two main file layouts - one for enumerations and one for classes.
In both cases the basename of the file determines the destination class name.
So the filename `Age.jdm` creates either an enum `Age` or a class `Age`.

### Enum file format 

A simple enumeration with three entries can be defined like this:

```json
{
  "RED" : "r",
  "GREEN" : "g",
  "BLUE" : "b"
}
```

This defines an enum with the enumeration constants `RED`, `GREEN` and `BLUE`.
The strings on the right side define the internal ID of the object. So enumeration constant `RED` has the internal ID `r`, `BLUE` has `b` etc.

The created class looks like this assuming the file was labeled `EDemo1.jdm`:

```java
public enum EDemo1
  implements IHasID<String> , IHasDisplayName
{
  RED("r", "r"),
  GREEN("g", "g"),
  BLUE("b", "b");
  private final String m_sID;
  private final String m_sDisplayName;

  private EDemo1(@Nonnull @Nonempty final String sID, @Nonnull @Nonempty final String sDisplayName) {
    m_sID = sID;
    m_sDisplayName = sDisplayName;
  }

  @Nonnull
  @Nonempty
  public String getID() {
    return m_sID;
  }

  @Nonnull
  @Nonempty
  public String getDisplayName() {
    return m_sDisplayName;
  }

  @Nullable
  public static EDemo1 getFromIDOrNull(@Nullable final String sID) {
    return EnumHelper.getFromIDOrNull(EDemo1 .class, sID);
  }

  @Nullable
  public static EDemo1 getFromIDOrDefault(@Nullable final String sID, @Nullable final EDemo1 eDefault) {
    return EnumHelper.getFromIDOrDefault(EDemo1 .class, sID, eDefault);
  }

  @Nonnull
  public static EDemo1 getFromIDOrThrow(@Nullable final String sID) {
    return EnumHelper.getFromIDOrThrow(EDemo1 .class, sID);
  }
}
```

Instead of just a simple ID (the string `"r"` in the above example) also a more sophisticated information can be provided.
When using a JSON array, the first entry is the internal ID, the second String is the "display name" associated with the entry, and the third entry is the source code comment.
If the array has one entry, the internal ID and the display name contain this value, but no comment is used.
If the array has two entries, the internal ID and the display name are, whereas the comment still stays empty.
If the array has more than three entries, the values are ignored.
Of course the definitions can be mixed between the different enum constants, so one entry can only have the ID, whereas another entry can have the internal ID, a display name and a comment.

So the following example is a valid enumeration definition:

```json
{
  "ALPHA" : "a",
  "RED" : [ "r" ],
  "GREEN" : [ "g", "green", "The green part." ],
  "BLUE" :  [ "b", "blue" ]
}
```

The created code looks as follows.
Note: The common parts (starting after the constructor) where omitted because it is identical to the previous example:

```java
package com.helger.aufnahme.small;

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.id.IHasID;
import com.helger.commons.lang.EnumHelper;
import com.helger.commons.name.IHasDisplayName;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public enum EDemo2
  implements IHasID<String> , IHasDisplayName
{
  ALPHA("a", "a"),
  RED("r", "r"),

  /**
   * The green part.
   */
  GREEN("g", "green"),
  BLUE("b", "blue");
  private final String m_sID;
  private final String m_sDisplayName;

  private EDemo2(@Nonnull @Nonempty final String sID, @Nonnull @Nonempty final String sDisplayName) {
    m_sID = sID;
    m_sDisplayName = sDisplayName;
  }
  ...
}
```
