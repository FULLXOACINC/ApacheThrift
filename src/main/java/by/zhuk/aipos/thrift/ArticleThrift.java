/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package by.zhuk.aipos.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2018-03-04")
public class ArticleThrift implements org.apache.thrift.TBase<ArticleThrift, ArticleThrift._Fields>, java.io.Serializable, Cloneable, Comparable<ArticleThrift> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ArticleThrift");

  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("name", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField INTO_FIELD_DESC = new org.apache.thrift.protocol.TField("into", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField BODY_FIELD_DESC = new org.apache.thrift.protocol.TField("body", org.apache.thrift.protocol.TType.STRING, (short)3);
  private static final org.apache.thrift.protocol.TField CODE_EXAMPLE_FIELD_DESC = new org.apache.thrift.protocol.TField("codeExample", org.apache.thrift.protocol.TType.STRING, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new ArticleThriftStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new ArticleThriftTupleSchemeFactory();

  public java.lang.String name; // required
  public java.lang.String into; // required
  public java.lang.String body; // required
  public java.lang.String codeExample; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    NAME((short)1, "name"),
    INTO((short)2, "into"),
    BODY((short)3, "body"),
    CODE_EXAMPLE((short)4, "codeExample");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // NAME
          return NAME;
        case 2: // INTO
          return INTO;
        case 3: // BODY
          return BODY;
        case 4: // CODE_EXAMPLE
          return CODE_EXAMPLE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("name", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.INTO, new org.apache.thrift.meta_data.FieldMetaData("into", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.BODY, new org.apache.thrift.meta_data.FieldMetaData("body", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CODE_EXAMPLE, new org.apache.thrift.meta_data.FieldMetaData("codeExample", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ArticleThrift.class, metaDataMap);
  }

  public ArticleThrift() {
  }

  public ArticleThrift(
    java.lang.String name,
    java.lang.String into,
    java.lang.String body,
    java.lang.String codeExample)
  {
    this();
    this.name = name;
    this.into = into;
    this.body = body;
    this.codeExample = codeExample;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ArticleThrift(ArticleThrift other) {
    if (other.isSetName()) {
      this.name = other.name;
    }
    if (other.isSetInto()) {
      this.into = other.into;
    }
    if (other.isSetBody()) {
      this.body = other.body;
    }
    if (other.isSetCodeExample()) {
      this.codeExample = other.codeExample;
    }
  }

  public ArticleThrift deepCopy() {
    return new ArticleThrift(this);
  }

  @Override
  public void clear() {
    this.name = null;
    this.into = null;
    this.body = null;
    this.codeExample = null;
  }

  public java.lang.String getName() {
    return this.name;
  }

  public ArticleThrift setName(java.lang.String name) {
    this.name = name;
    return this;
  }

  public void unsetName() {
    this.name = null;
  }

  /** Returns true if field name is set (has been assigned a value) and false otherwise */
  public boolean isSetName() {
    return this.name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.name = null;
    }
  }

  public java.lang.String getInto() {
    return this.into;
  }

  public ArticleThrift setInto(java.lang.String into) {
    this.into = into;
    return this;
  }

  public void unsetInto() {
    this.into = null;
  }

  /** Returns true if field into is set (has been assigned a value) and false otherwise */
  public boolean isSetInto() {
    return this.into != null;
  }

  public void setIntoIsSet(boolean value) {
    if (!value) {
      this.into = null;
    }
  }

  public java.lang.String getBody() {
    return this.body;
  }

  public ArticleThrift setBody(java.lang.String body) {
    this.body = body;
    return this;
  }

  public void unsetBody() {
    this.body = null;
  }

  /** Returns true if field body is set (has been assigned a value) and false otherwise */
  public boolean isSetBody() {
    return this.body != null;
  }

  public void setBodyIsSet(boolean value) {
    if (!value) {
      this.body = null;
    }
  }

  public java.lang.String getCodeExample() {
    return this.codeExample;
  }

  public ArticleThrift setCodeExample(java.lang.String codeExample) {
    this.codeExample = codeExample;
    return this;
  }

  public void unsetCodeExample() {
    this.codeExample = null;
  }

  /** Returns true if field codeExample is set (has been assigned a value) and false otherwise */
  public boolean isSetCodeExample() {
    return this.codeExample != null;
  }

  public void setCodeExampleIsSet(boolean value) {
    if (!value) {
      this.codeExample = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((java.lang.String)value);
      }
      break;

    case INTO:
      if (value == null) {
        unsetInto();
      } else {
        setInto((java.lang.String)value);
      }
      break;

    case BODY:
      if (value == null) {
        unsetBody();
      } else {
        setBody((java.lang.String)value);
      }
      break;

    case CODE_EXAMPLE:
      if (value == null) {
        unsetCodeExample();
      } else {
        setCodeExample((java.lang.String)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case NAME:
      return getName();

    case INTO:
      return getInto();

    case BODY:
      return getBody();

    case CODE_EXAMPLE:
      return getCodeExample();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case NAME:
      return isSetName();
    case INTO:
      return isSetInto();
    case BODY:
      return isSetBody();
    case CODE_EXAMPLE:
      return isSetCodeExample();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof ArticleThrift)
      return this.equals((ArticleThrift)that);
    return false;
  }

  public boolean equals(ArticleThrift that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_name = true && this.isSetName();
    boolean that_present_name = true && that.isSetName();
    if (this_present_name || that_present_name) {
      if (!(this_present_name && that_present_name))
        return false;
      if (!this.name.equals(that.name))
        return false;
    }

    boolean this_present_into = true && this.isSetInto();
    boolean that_present_into = true && that.isSetInto();
    if (this_present_into || that_present_into) {
      if (!(this_present_into && that_present_into))
        return false;
      if (!this.into.equals(that.into))
        return false;
    }

    boolean this_present_body = true && this.isSetBody();
    boolean that_present_body = true && that.isSetBody();
    if (this_present_body || that_present_body) {
      if (!(this_present_body && that_present_body))
        return false;
      if (!this.body.equals(that.body))
        return false;
    }

    boolean this_present_codeExample = true && this.isSetCodeExample();
    boolean that_present_codeExample = true && that.isSetCodeExample();
    if (this_present_codeExample || that_present_codeExample) {
      if (!(this_present_codeExample && that_present_codeExample))
        return false;
      if (!this.codeExample.equals(that.codeExample))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetName()) ? 131071 : 524287);
    if (isSetName())
      hashCode = hashCode * 8191 + name.hashCode();

    hashCode = hashCode * 8191 + ((isSetInto()) ? 131071 : 524287);
    if (isSetInto())
      hashCode = hashCode * 8191 + into.hashCode();

    hashCode = hashCode * 8191 + ((isSetBody()) ? 131071 : 524287);
    if (isSetBody())
      hashCode = hashCode * 8191 + body.hashCode();

    hashCode = hashCode * 8191 + ((isSetCodeExample()) ? 131071 : 524287);
    if (isSetCodeExample())
      hashCode = hashCode * 8191 + codeExample.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(ArticleThrift other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetName()).compareTo(other.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.name, other.name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetInto()).compareTo(other.isSetInto());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetInto()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.into, other.into);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetBody()).compareTo(other.isSetBody());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBody()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.body, other.body);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetCodeExample()).compareTo(other.isSetCodeExample());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCodeExample()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.codeExample, other.codeExample);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("ArticleThrift(");
    boolean first = true;

    sb.append("name:");
    if (this.name == null) {
      sb.append("null");
    } else {
      sb.append(this.name);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("into:");
    if (this.into == null) {
      sb.append("null");
    } else {
      sb.append(this.into);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("body:");
    if (this.body == null) {
      sb.append("null");
    } else {
      sb.append(this.body);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("codeExample:");
    if (this.codeExample == null) {
      sb.append("null");
    } else {
      sb.append(this.codeExample);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ArticleThriftStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ArticleThriftStandardScheme getScheme() {
      return new ArticleThriftStandardScheme();
    }
  }

  private static class ArticleThriftStandardScheme extends org.apache.thrift.scheme.StandardScheme<ArticleThrift> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ArticleThrift struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.name = iprot.readString();
              struct.setNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // INTO
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.into = iprot.readString();
              struct.setIntoIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // BODY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.body = iprot.readString();
              struct.setBodyIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // CODE_EXAMPLE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.codeExample = iprot.readString();
              struct.setCodeExampleIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ArticleThrift struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.name != null) {
        oprot.writeFieldBegin(NAME_FIELD_DESC);
        oprot.writeString(struct.name);
        oprot.writeFieldEnd();
      }
      if (struct.into != null) {
        oprot.writeFieldBegin(INTO_FIELD_DESC);
        oprot.writeString(struct.into);
        oprot.writeFieldEnd();
      }
      if (struct.body != null) {
        oprot.writeFieldBegin(BODY_FIELD_DESC);
        oprot.writeString(struct.body);
        oprot.writeFieldEnd();
      }
      if (struct.codeExample != null) {
        oprot.writeFieldBegin(CODE_EXAMPLE_FIELD_DESC);
        oprot.writeString(struct.codeExample);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ArticleThriftTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ArticleThriftTupleScheme getScheme() {
      return new ArticleThriftTupleScheme();
    }
  }

  private static class ArticleThriftTupleScheme extends org.apache.thrift.scheme.TupleScheme<ArticleThrift> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ArticleThrift struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetName()) {
        optionals.set(0);
      }
      if (struct.isSetInto()) {
        optionals.set(1);
      }
      if (struct.isSetBody()) {
        optionals.set(2);
      }
      if (struct.isSetCodeExample()) {
        optionals.set(3);
      }
      oprot.writeBitSet(optionals, 4);
      if (struct.isSetName()) {
        oprot.writeString(struct.name);
      }
      if (struct.isSetInto()) {
        oprot.writeString(struct.into);
      }
      if (struct.isSetBody()) {
        oprot.writeString(struct.body);
      }
      if (struct.isSetCodeExample()) {
        oprot.writeString(struct.codeExample);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ArticleThrift struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(4);
      if (incoming.get(0)) {
        struct.name = iprot.readString();
        struct.setNameIsSet(true);
      }
      if (incoming.get(1)) {
        struct.into = iprot.readString();
        struct.setIntoIsSet(true);
      }
      if (incoming.get(2)) {
        struct.body = iprot.readString();
        struct.setBodyIsSet(true);
      }
      if (incoming.get(3)) {
        struct.codeExample = iprot.readString();
        struct.setCodeExampleIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

