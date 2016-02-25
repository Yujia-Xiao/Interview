//duplicate files

File file = new File("c:\\temp\\java\\testfile");
    if(!file.exists()){
        file = file.getParentFile();
    }


if(file.isDirectory()){
    System.out.println("file is directory ");
}

long    length()
delete()

int hashCode()

String[]    list()