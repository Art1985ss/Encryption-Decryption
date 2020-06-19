class AsciiCharSequence implements CharSequence {
    private byte[] charBytes;

    public AsciiCharSequence(byte[] charBytes) {
        this.charBytes = charBytes.clone();
    }

    @Override
    public int length() {
        return charBytes.length;
    }

    @Override
    public char charAt(int i) {
        return (char) charBytes[i];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(java.util.Arrays.copyOfRange(charBytes, start, end));
    }

    @Override
    public String toString() {
        return new String(this.charBytes);
    }
}