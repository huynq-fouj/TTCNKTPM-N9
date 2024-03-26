import { useCallback, useState } from "react"

export default function AuthForm() {

    const [variant, setVariant] = useState<string>('LOGIN');
    const [isLoading, setIsLoading] = useState<boolean>(false);



    const toggleVariant = useCallback(() => {
        setVariant(prev => prev === 'LOGIN' ? 'REGISTER' : 'LOGIN');
    }, [variant]);


    return (
        <>
            <h2>{ variant } form</h2>
        </>
    )
}