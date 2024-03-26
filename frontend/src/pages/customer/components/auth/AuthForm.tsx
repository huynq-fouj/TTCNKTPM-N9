import { useCallback, useState } from "react"
import AuthService from "../../../../shared/services/AuthService";
import toast from "react-hot-toast";

export default function AuthForm() {

    const [variant, setVariant] = useState<string>('LOGIN');
    const [isLoading, setIsLoading] = useState<boolean>(false);

    const toggleVariant = useCallback(() => {
        setVariant(prev => prev === 'LOGIN' ? 'REGISTER' : 'LOGIN');
    }, [variant]);

    const onSubmit = (data: any) => {
        setIsLoading(true);
        if(variant === 'LOGIN') {
            AuthService.login(data).then(res => {
                //Lưu thông tin đăng nhập của user sau khi đăng nhập
                console.log(res);
                toast.error("Đăng nhập thành công");
            }).catch(err => {
                console.log(err);
                toast.error("Đăng nhập không thành công");
            }).finally(() => {
                setIsLoading(false);
            });
        }

        if(variant === 'REGISTER') {
            AuthService.register(data).then(res => {
                //Lưu thông tin đăng nhập của user sau khi đăng nhập
                console.log(res);
                toast.success("Đăng ký thành công");
            }).catch(err => {
                console.log(err);
                toast.error("Đăng ký không thành công");
            }).finally(() => {
                setIsLoading(false);
            });
        }
    }

    return (
        <>
            <h2>Login and register</h2>
        </>
    )
}