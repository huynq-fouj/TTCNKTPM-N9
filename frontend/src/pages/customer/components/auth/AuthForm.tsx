import { useCallback, useEffect, useState } from "react"
import { useLocation } from "react-router-dom";

const LOGIN = 'LOGIN';
const REGISTER = 'REGISTER';

export default function AuthForm() {

    const [variant, setVariant] = useState<string>(LOGIN);
    const [isLoading, setIsLoading] = useState<boolean>(false);
    const location = useLocation();

    //Thay đổi variant khi phần hash của location chứa #register
    useEffect(() => {
        if(location.hash.includes('#register')) setVariant(REGISTER);
        else setVariant(LOGIN);
    }, [location]);

    const toggleVariant = useCallback(() => {
        setVariant(prev => prev === LOGIN ? REGISTER : LOGIN);
    }, [variant]);


    return (
        <>
            <div className="pt-5"></div>
            <h2>{ variant } form</h2>
        </>
    )
}