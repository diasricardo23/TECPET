#include <jni.h>
#include <string>

extern "C"
JNIEXPORT jstring JNICALL
Java_br_com_engnetconsultoria_tecpet_TecPet_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
